def acirustech
node("master") {
  stage('Pull the Code') {
    git url: "https://github.com/fuchicorp/acirustech.git"
  }

  stage('Build') {
    acirustech = docker.build("sharifabdulcoder/acirustech")
  }
  withCredentials([usernameColonPassword(credentialsId: 'ID', variable: 'docker_cred')]) {
      // some block
  }
  stage('Push image') {

   // Push docker image to the Docker hub
    docker.withRegistry('', 'docker_cred') {
        app.push("0.1")
        app.push("latest")
    }


  stage("Deploy"){
      sh "docker run -dti -p 81:5000 sharifabdulcoder/acirustech"

    }

}
