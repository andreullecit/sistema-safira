pipeline {
    agent any
    stages {
        withMaven {
            stage('build') {
                steps {
                    sh 'mvn --version'
                }
            }
        }
    }
}