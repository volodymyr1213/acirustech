bin/#!/usr/bin/env bash

sudo yum update -y
sudo yum install -y docker
sudo service docker start
sudo usermod -a -G docker ec2-user

sudo docker run -dti -p 80:5000 sharifabdulcoder/acirustech
