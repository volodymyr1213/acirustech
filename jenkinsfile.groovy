def acirustech
node("master"){
    stage('Pull the Code'){
        git branch: 'nurjan_groovy', url: 'https://github.com/fuchicorp/acirustech.git'

    }
    stage('Build'){
        acirustech = docker.build("nurjandocker/fuchcorp")

    }
    // statge('Unites'){
    //    acirustech.inside("""
    //    #!/bin/bash
    //    ls /app/requirements.txt
    //    ls /app/app.py
     //   ls /app/temlates/
      //  """)

    }
    stage('deploy'){

    }
    stage('Push image') {

     // Push docker image to the Docker hub
      docker.withRegistry('', 'nurjandocker') {
           acirustec.push("0.1")
           acirustech.push("latest")
      }
}

stage("Terraform plan"){
      sh "terraform plan"

    }

    stage("Terraform apply"){
        sh "terraform apply --auto-approve"

      }

}
