package main

import (
	"flag"
	api "go_server/api/grpc"
	"go_server/api/grpc/server"
	"go_server/cmd/config"
	"net"

	"github.com/sirupsen/logrus"
	"google.golang.org/grpc"
)

func main() {

	// get application config
	confFlag := flag.String("conf", "", "config yaml file")
	flag.Parse()

	confString := *confFlag
	if confString == "" {
		logrus.Fatal(" 'conf' flag required")
	}
	conf, err := config.Parse(confString)
	if err != nil {
		logrus.Fatal(err)
	}

	logrus.Println(*conf)
	logrus.Println("Starting the service...")

	s := grpc.NewServer()
	srv := &server.GRPCServer{}
	api.RegisterDatabaseServer(s, srv)

	l, err := net.Listen("tcp", conf.AppPort)
	if err != nil {
		logrus.WithFields(logrus.Fields{
			"Host": conf.AppPort,
		}).Fatal(err)
	}

	if err := s.Serve(l); err != nil {
		logrus.WithFields(logrus.Fields{
			"Host": conf.AppPort,
		}).Fatal(err)
	}
}
