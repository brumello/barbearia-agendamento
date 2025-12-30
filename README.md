# Sistema de Agendamento para Barbearia

 Este projeto consiste em um sistema simples de agendamento para um pequeno salão/barbearia, desenvolvido em Java com Spring Boot, com o objetivo de facilitar o controle de horários do barbeiro e permitir que clientes realizem agendamentos sem conflitos.

O sistema foi desenvolvido como projeto pessoal, aplicando boas práticas de organização de código, versionamento com Git e arquitetura REST.

# Tecnologias Utilizadas

Java 21+

Spring Boot

Spring Web

Spring Data JPA

H2 Database

Maven

Postman

Git e GitHub

# Funcionalidades do Sistema

- Agendamento de horários de 1 em 1 hora

- Impede dois clientes no mesmo horário

- Exibe valores dos serviços:

Corte → R$ 35,00

Barba → R$ 15,00

- Barbeiro define o horário de funcionamento

- Barbeiro pode fechar a agenda

- API REST simples e organizada

- Tratamento global de erros com mensagens claras

# Regras de Negócio

Não é permitido criar dois agendamentos para o mesmo dia e horário

Agendamentos só podem ser feitos se a agenda estiver aberta

A agenda precisa ser definida antes de qualquer agendamento

Horários seguem o padrão de 1 em 1 hora


# Como Executar o Projeto
Pré-requisitos

Java 21 ou superior

Maven

IDE (Spring Tools for Eclipse recomendado)

# Passos

- Clone o repositório:

git clone https://github.com/SEU_USUARIO/barbearia-agendamento.git


- Importe o projeto como Existing Maven Project no Eclipse

  Execute a classe:

BarbeariaApplication.java


- A aplicação iniciará em:

http://localhost:8080

# Testes com Postman
Criar agenda do barbeiro
POST /agenda

{
  
  "horaInicio": "09:00",
  
  "horaFim": "18:00",
  
  
  "fechada": false

}

Criar agendamento
POST /agendamentos

{
  
  "data": "2025-02-10",
  
  "horario": "14:00",
  
  
  "tipoServico": "CORTE"

}

Fechar agenda
PUT /agenda/fechar/{id}

# Tratamento de Erros

O sistema utiliza exceptions personalizadas e um handler global, retornando mensagens claras em formato JSON.

Exemplo:

{

  "status": 400,
  
  "erro": "HORARIO_OCUPADO",
  
  "mensagem": "Já existe um agendamento para este horário"
  
}

## Autor

Bruno Mello

Estudante de Engenharia de Software

Projeto desenvolvido para fins acadêmicos e portfólio.
