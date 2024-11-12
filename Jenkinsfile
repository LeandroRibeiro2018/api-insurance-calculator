pipeline {
    agent any

    environment {
        MAVEN_HOME = 'C:\\Develop\\apache-maven-3.9.6\\bin'  // Defina o caminho do Maven aqui
        PATH = "${env.PATH};${env.MAVEN_HOME}"
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Realizando checkout do código...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compilando o aplicativo Spring Boot...'
                bat '"%MAVEN_HOME%\\mvn" clean install'
            }
        }

        stage('Test') {
            steps {
                echo 'Executando testes...'
                bat '"%MAVEN_HOME%\\mvn" test'
            }
        }

        stage('Run Application') {
            steps {
                echo 'Iniciando o aplicativo Spring Boot...'
                bat '"%MAVEN_HOME%\\mvn" spring-boot:run'
            }
        }
    }

    post {
        always {
            echo 'Pipeline concluído!'
        }
        success {
            echo 'Pipeline executado com sucesso.'
        }
        failure {
            echo 'Pipeline falhou.'
        }
    }
}
