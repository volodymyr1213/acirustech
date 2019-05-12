esource "aws_instance" "acirrustech" {
  ami           = ""
  instance_type = ""
  count         = "t2.micro"
  key_name      = "mac"
  user_data     = "${file("acirrustech.sh")}"
}

# resource "aws_route53_zone" "primary" {
#   name = "uzbozor.com"
# }

resource "aws_route53_record" "acirrustech" {
  zone_id = "${aws_route53_zone.primary.zone_id}"
  name    = "acirrustech.example.com"
  type    = "A"
  ttl     = "300"
  records = ["${aws_instance.acirrustech.public_ip}"]
}
