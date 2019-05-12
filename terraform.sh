bin/#!/usr/bin/env bash

sudo yum update -y
sudo yum install -y docker
sudo service docker start
sudo usermod -a -G docker ec2-user

sh "docker run -dti -p 67:5000 50364747/centos_jenkins:latest"
