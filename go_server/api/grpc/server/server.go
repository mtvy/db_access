package server

import (
	"context"
	api "go_server/api/grpc"
	"go_server/internal/service/database"
	"go_server/internal/service/utils"
)

type host string

// GRPCServer ...
type GRPCServer struct {
	api.UnimplementedDatabaseServer
}

func (server *GRPCServer) GetDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {

	db := database.Database{Host: req.DbHost}
	data, err := db.Get(req.Columns, req.Table, req.Condition)
	if err != nil {
		return &api.GetDbResponse{Status: err.Error(), Data: []byte{}}, nil
	}

	jsonData, err := utils.AnyToJson(data)
	if err != nil {
		return &api.GetDbResponse{Status: err.Error(), Data: []byte{}}, nil
	}

	return &api.GetDbResponse{Status: "ok", Data: jsonData}, nil
}

func (server *GRPCServer) InsertDb(ctx context.Context, req *api.InsertDbRequest) (*api.InsertDbResponse, error) {
	db := database.Database{Host: req.DbHost}
	_, err := db.Insert(req.Table, req.Columns, req.Values)
	if err != nil {
		return &api.InsertDbResponse{Status: err.Error()}, nil
	}
	return &api.InsertDbResponse{Status: "ok"}, nil
}

func (server *GRPCServer) DeleteDb(ctx context.Context, req *api.DeleteDbRequest) (*api.DeleteDbResponse, error) {
	db := database.Database{Host: req.DbHost}
	_, err := db.Delete(req.Table, req.Condition)
	if err != nil {
		return &api.DeleteDbResponse{Status: err.Error()}, nil
	}
	return &api.DeleteDbResponse{Status: "ok"}, nil
}
