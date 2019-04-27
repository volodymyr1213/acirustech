node('master') {
  
  @Library('CommonLib@master') _
  def common = new com.lib.JenkinsDeployerPipeline()

  def dockerImage
  def branchName = "${scm.branches[0].name}".replaceAll(/^\*\//, '').replace("/", "-").toLowerCase()

  // Poll the application to workspace
  stage('Checkout SCM') {
    git 'https://github.com/fuchicorp/acirustech.git'
  }


  // Build the docker image
  stage('Build') {
    dockerImage = docker.build("acirustech-${branchName}")
  }


  // Unitest the application
  stage('Unitest') {
    dockerImage.inside {
      sh 'ls /app/app.py'
    }
  }


  // Push the application to private repository
  stage('Push') {
    docker.withRegistry('http://nexus.fuchicorp.com:8086', 'docker-private-credentials') {
            dockerImage.push("${BUILD_NUMBER}")
            dockerImage.push("latest")
        }
  }
}
