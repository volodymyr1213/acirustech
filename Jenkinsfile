

def remote_user = 'root'
def remote_host = '34.253.221.145'


node('master') {
  stage('poll the code') {

    // If folder does not exist jenkins will create that folder
    if(!fileExists("${WORKSPACE}/deployment")) {
      sh "mkdir ${WORKSPACE}/deployment"
    }

    // Checkout scm means download latest changes
    dir("${WORKSPACE}/deployment") {
      checkout scm
    }
  }

  stage('Sync To Remote') {
    sh "rsync -avW --delete-before -e ssh ${WORKSPACE}/deployment ${remote_user}@${remote_host}:/artemis"
  }

  stage('Build Docker') {
    sh "ssh ${remote_user}@${remote_host} cd /artemis && docker build -t artemis . "
  }


  stage('Run/App') {
    sh "ssh ${remote_user}@${remote_host} docker run -dti -p 80:5000 artemis "
  }



}
