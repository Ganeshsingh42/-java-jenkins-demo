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
        sh 'mvn clean install'
        junit 'target/surefire-reports/*.xml'        
      }
    }
    stage('Package') {
    steps {
        sh 'mvn package -DskipTests'
        archiveArtifacts 'target/java-jenkins-demo-1.0.0.jar'
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
