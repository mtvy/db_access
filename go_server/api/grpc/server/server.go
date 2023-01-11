package server

import (
	"context"
	api "go_server/api/grpc"
	"go_server/internal/service/utils"
)

type host string

// GRPCServer ...
type GRPCServer struct {
	api.UnimplementedDatabaseServer
}

func (server *GRPCServer) GetDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {

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

func (server *GRPCServer) InsertDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {
	//status, data := db.Insert()
	return &api.GetDbResponse{}, nil
}

func (server *GRPCServer) DeleteDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {
	//status, data := db.Delete()
	return &api.GetDbResponse{}, nil
}
