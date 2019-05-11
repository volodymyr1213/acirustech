def acirrustech
node("master") {
  stage("Pull the code"){
    git 'git@github.com:fuchicorp/acirustech.git'
  }

  stage("Build"){
    acirrustech = docker.build("sharifabdulcoder/fuchicorp")

  }


  // stage("Unites"){
  //   acirrustech.inside("""
  //   #!/bin/bash
  //   ls /app/requirements.txt
  //   cat /app/app.py
  //   ls /app/templates/
  //   """)
  //
  // }


  stage("Deploy"){
    docker.run("sharifabdulcoder/fuchicorp")

  }
}
