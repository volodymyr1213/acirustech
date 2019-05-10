def acirustech
node("master") {
  stage('Pull the Code') {
    git url: "https://github.com/fuchicorp/acirustech.git"
  }

  stage('Build') {
    acirustech = docker.build("fsadykov/acirustech")
  }

  stage('Unites') {
    acirustech.inside("""
    #!/bin/bash
    ls /app/requirements.txt
    ls /app/app.py
    ls /app/templates/
    """)
  }

}
