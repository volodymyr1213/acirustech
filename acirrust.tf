esource "aws_instance" "web" {
  ami           = ""
  instance_type = ""
  count         = "t2.micro"
  key_name      = "mac"
  user_data     = "${file("acirrustech")}"
}
