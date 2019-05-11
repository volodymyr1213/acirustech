def acirrustech
node("master") {
  stage("Pull the code"){
    git 'git@github.com:fuchicorp/acirustech.git'
  }

  // stage("Build"){
  //   acirrustech = docker.build("sharifabdulcoder/fuchicorp")
  //
  // }
  // // stage("Deploy"){
  // //   docker.run("sharifabdulcoder/fuchicorp")
  // //
  // // }
}
