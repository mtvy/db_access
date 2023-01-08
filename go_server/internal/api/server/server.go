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
	//status, data := server.db.Get()
	return &api.GetDbResponse{}, nil
}

func (server *GRPCServer) InsertDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {
	//status, data := server.db.Insert()
	return &api.GetDbResponse{}, nil
}

func (server *GRPCServer) DeleteDb(ctx context.Context, req *api.GetDbRequest) (*api.GetDbResponse, error) {
	//status, data := server.db.Delete()
	return &api.GetDbResponse{}, nil
}
