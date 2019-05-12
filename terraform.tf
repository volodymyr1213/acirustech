resource "aws_instance" "Docker" {
  ami           = ""
  instance_type = ""
  count         = "t2.micro"
  key_name      = "dilfuza"
}

resource "aws_route53_zone" "primary" {
  name = "dilfuza.net"
}
