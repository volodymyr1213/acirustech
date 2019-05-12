def acirustech
node("master") {
  stage('Pull the Code') {
    git url: "https://github.com/fuchicorp/acirustech.git"
  }

  stage('Build') {
    acirustech = docker.build("50364747/centos_jenkins:latest")
  }
  withCredentials([usernameColonPassword(credentialsId: 'ID', variable: 'docker_cred')]) {
      // some block
  }
  stage('Push image') {

   // Push docker image to the Docker hub
    docker.withRegistry('', 'ID') {
        acirustech.push("0.1")
        acirustech.push("latest")
    }
  }

  stage("Deploy"){
      sh "docker run -dti -p 80:8080 50364747/acirustech"

    }
}
