
from dataclasses import dataclass

@dataclass
class Produto:
    nome: str
    quantidade: int
    preco: float

carrinho = [] # lista onde ficarao os produtos cadastrados

sair = 'n';
while sair not in "Ss":
    nome = input("Produto: ");
    quantidade = int(input("Quantidade: "));
    preco = float(input("Preço unitário: "));

    produto = Produto(nome, quantidade, preco);
    carrinho.append(produto)
    sair = input("Produto adicionado com sucesso! Deseja sair? [s/n]\n");

# calcular o subtotal 
subtotal = 0
for i in carrinho:
    subtotal += i.quantidade * i.preco

# calcular o desconto
desconto = 0;
total = subtotal;
if subtotal > 500:
    total *= 0.90
    desconto = subtotal * 0.1

elif subtotal > 200:
    total *= 0.95
    desconto = subtotal * 0.05

    # imprimir cupom
print(f'{"PRODUTO":20}{"QTD":4}{"PREÇO":>20}\n')
for i in carrinho:
    print(f'{i.nome:20}{i.quantidade:<4}{i.preco:>20.2f}')

print(f'\nSUBTOTAL:{subtotal:.>35.2f}\nDESCONTO:{desconto:.>35}\nTOTAL:{total:.>38.2f}')
