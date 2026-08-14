pipeline {
  agent any
  tools {
    maven 'maven'
    jdk 'JDK17'
  }
  stages{
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      step {
        sh 'mvn clean package'
      }
    }
    stage('Test') {
      step {
        sh 'mvn test'
      }
    }
  }
  post {
    success {
      echo 'Java CI Pipline Completed successfully!'
    }
    failure {
      echo 'Java CI Pipeline failed.'
    }
  }
}
