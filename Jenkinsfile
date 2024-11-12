pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Compilando o aplicativo Spring Boot...'
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Executando os testes...'
                bat 'mvn test'
            }
        }
        stage('Iniciar Aplicação') {
            steps {
                echo 'Iniciando a aplicação...'
                bat 'java -jar target/SeuAplicativoSpringBoot.jar'
            }
        }
    }
    post {
        always {
            echo 'Pipeline completo!'
        }
        success {
            echo 'Pipeline executado com sucesso!'
        }
        failure {
            echo 'Pipeline falhou.'
        }
    }
}
