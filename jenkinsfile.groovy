node("master"){
    stage('Pull the Code'){
        git https://@github.com:fuchicorp/acirustech.git"

    }
    stage('Build'){
        acirustech = docker.build("nurjandocker/fuchcorp")

    }
    statge('Unites'){
        acirustech.inside("""
        #!/bin/bash
        ls /app/requirements.txt
        ls /app/app.py
        ls /app/temlates/
        """)

    }
    stage('deploy'){

    }
}