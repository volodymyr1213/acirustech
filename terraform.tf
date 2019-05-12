resource "aws_instance" "Docker" {
  ami           = ""
  instance_type = ""
  count         = "t2.micro"
  key_name      = "dilfuza"
}
