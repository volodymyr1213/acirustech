resource "aws_instance" "Docker" {
  ami           = ""
  instance_type = "t2.micro"
  count         = "1"
  key_name      = "dilfuza"
  region         = "eu-west-1"
   user_data     = "${file("acirrustech.sh")}"
}

resource "aws_route53_zone" "docker" {
  name = "dilfuza.net"
}
