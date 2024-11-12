pipeline {
    agent any

    environment {
        WORKSPACE_DIR = "/var/lib/jenkins/workspace/api-insurance-calculator"
        PORT_NUMBER = "8085" // Porta da aplicação
    }

    stages {
        stage('Notificar Início') {
            steps {
                script {
                    notifyBuild('STARTED')
                }
            }
        }

        stage('Clonar Repositório') {
            steps {
                git url: 'https://github.com/LeandroRibeiro2018/api-insurance-calculator.git',
                    credentialsId: 'tokenGithub',
                    branch: 'main'
            }
        }

        stage('Compilar Aplicação') {
            steps {
                script {
                    echo "Compilando aplicação Spring Boot..."
                    sh "mvn -f ${WORKSPACE_DIR}/pom.xml clean package -DskipTests"
                }
            }
        }

        stage('Iniciar Aplicação') {
            steps {
                script {
                    echo "Iniciando aplicação na porta ${PORT_NUMBER}..."
                    // Verifica se a aplicação já está em execução e para, se necessário
                    sh "lsof -t -i:${PORT_NUMBER} | xargs kill -9 || true"
                    // Inicia a aplicação
                    sh "nohup java -jar ${WORKSPACE_DIR}/target/*.jar --server.port=${PORT_NUMBER} &"
                }
            }
        }
    }

    post {
        always {
            script {
                notifyBuild(currentBuild.result ?: 'SUCCESS')
            }
        }
        failure {
            script {
                currentBuild.result = 'FAILURE'
                notifyBuild('FAILURE')
            }
        }
    }
}

def notifyBuild(String buildStatus = 'STARTED') {
    // Definindo status padrão e cores de notificação
    buildStatus = buildStatus ?: 'SUCCESSFUL'
    def colorName = buildStatus == 'SUCCESSFUL' ? 'GREEN' : 'RED'
    def now = new Date()
    def subject = "${buildStatus} - Job: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER}"
    def details = """<p>${buildStatus} JOB</p>
        <p>Job: ${env.JOB_NAME} - Build #${env.BUILD_NUMBER} - Time: ${now}</p>
        <p>Console output: "<a href="${env.BUILD_URL}">${env.JOB_NAME}</a>"</p>"""
    
    // Exemplo de notificação por e-mail (descomente para ativar)
    /*
    emailext (
        to: "leandro.ribeiro@kardbank.com.br",
        subject: subject,
        body: details,
        recipientProviders: [[$class: 'DevelopersRecipientProvider']]
    )
    */
}
