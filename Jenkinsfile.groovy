def acirustech
node("master") {
  stage('Pull the Code') {
    git url: "https://github.com/fuchicorp/acirustech.git"
  }

  stage('Build') {
    acirustech = docker.build("sharifabdulcoder/acirustech")
  }

  stage("Deploy"){
      sh "docker run -dti -p 81:5000 sharifabdulcoder/acirustech"

    }
}

//
//
//
//
// def acirrustech
// node("master") {
//   stage("Pull the code"){
//     git 'git@github.com:fuchicorp/acirustech.git'
//   }
//
//   stage("Build"){
//     acirrustech = docker.build("sharifabdulcoder/fuchicorp")
//
//   }
//   stage("Deploy"){
//     docker.run("sharifabdulcoder/fuchicorp")
//
//   }
// }
