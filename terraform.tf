resource "aws_instance" "Docker" {
  ami           = ""
  instance_type = "t2.micro"
  count         = "1"
  key_name      = "dilfuza"
  region         = "eu-west-1"
}

resource "aws_route53_zone" "docker" {
  name = "dilfuza.net"
}
