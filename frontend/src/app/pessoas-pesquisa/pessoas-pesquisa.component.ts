import { Component } from '@angular/core';

@Component({
  selector: 'app-pessoas-pesquisa',
  templateUrl: './pessoas-pesquisa.component.html',
  styleUrls: ['./pessoas-pesquisa.component.css']
})
export class PessoasPesquisaComponent {

  pessoas = [
  { nome: 'Davi Luís Pedro Henrique Silveira', cidade: 'Palmas', estado: 'TO', ativo: true},
	{ nome: 'Otávio Yuri Manoel Moreira', cidade: 'Boa Vista', estado: 'RR', ativo: false},
	{ nome: 'Rosa Caroline Ferreira', cidade: 'São Mateus', estado: 'ES', ativo: true},
	{ nome: 'Rosa Jaqueline Cecília da Rocha', cidade: 'Macapá', estado: 'AP', ativo: false},
	{ nome: 'Giovana Carla Teixeira', cidade: 'Imperatriz', estado: 'MA', ativo: false},
	{ nome: 'Isabela Alessandra Heloisa Costa', cidade: 'Catalão', estado: 'GO', ativo: true},
	{ nome: 'Gabrielly Joana Isabelly Galvão', cidade: 'Brasília', estado: 'DF', ativo: true},
	{ nome: 'Nicolas Matheus Almeida', cidade: 'Boa Vista', estado: 'RR', ativo: false}
  ];

}
