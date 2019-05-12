def acirustech
node("master") {
  stage('Pull the Code') {
    git url: "https://github.com/fuchicorp/acirustech.git"
  }

  stage('Build') {
    acirustech = docker.build("sharifabdulcoder/acirustech")
  }

  stage('Push image') {

   // Push docker image to the Docker hub
    docker.withRegistry('', 'abdul_dockerhub') {
        acirustech.push("0.1")
        acirustech.push("latest")
    }
  }

  stage("Deploy"){
      sh "docker run -dti -p 81:5000 sharifabdulcoder/acirustech"

    }

}
