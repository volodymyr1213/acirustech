

def remote_user = 'root'
def remote_host = '100.24.34.8'


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
    
    // Sync local file to remote system and make sure all changes on remote system
    sh "rsync -avW --delete-before -e ssh ${WORKSPACE}/deployment ${remote_user}@${remote_host}:/"
  }

  stage('Build Docker') {

    // Generate script to run application on remote system
    def file = new File("${WORKSPACE}/deployment/runner-artemis.sh")
    file.write """#!/bin/bash
    cd /deployment
    docker-compose up --build -d
    """
    // Build and run the application.
    sh "ssh ${remote_user}@${remote_host} 'bash -s' < ${WORKSPACE}/deployment/runner-artemis.sh"
  }

}
