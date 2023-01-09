package server

import (
	"context"
	"go_server/internal/api"
	"go_server/internal/service/database"
)

// GRPCServer ...
type GRPCServer struct {
	api.UnimplementedDatabaseServer
	db database.Database
}

func (server *GRPCServer) GetDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {
	data, err := server.db.Get(req.Columns, req.Table, req.Condition)
	if err != nil {
		return &api.GetDbResponse{Status: err.Error(), Data: data}, nil
	}
	return &api.GetDbResponse{Status: "ok", Data: data}, nil
}

func (server *GRPCServer) InsertDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {
	//status, data := server.db.Insert()
	return &api.GetDbResponse{}, nil
}

func (server *GRPCServer) DeleteDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {
	//status, data := server.db.Delete()
	return &api.GetDbResponse{}, nil
}
