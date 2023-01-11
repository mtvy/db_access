package main

import (
	api "go_server/api/grpc"
	"go_server/api/grpc/server"
	"net"

	"github.com/sirupsen/logrus"
	"google.golang.org/grpc"
)

func main() {
	s := grpc.NewServer()
	srv := &server.GRPCServer{}
	api.RegisterDatabaseServer(s, srv)

	l, err := net.Listen("tcp", ":8080")
	if err != nil {
		logrus.WithFields(logrus.Fields{
			"host": ":8080",
		}).Fatal(err)
	}

	if err := s.Serve(l); err != nil {
		logrus.WithFields(logrus.Fields{
			"host": ":8080",
		}).Fatal(err)
	}
}
