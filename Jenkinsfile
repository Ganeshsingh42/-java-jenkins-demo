pipeline {
  agent any
  tools {
    maven 'maven'
    jdk 'JDK21'
  }
  stages{
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build') {
      steps {
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
      steps {
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
