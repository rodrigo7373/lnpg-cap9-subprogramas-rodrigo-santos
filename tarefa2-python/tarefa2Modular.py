
from dataclasses import dataclass

@dataclass
class Produto:
    nome: str = ""
    quantidade: int = 0
    preco: float = 0

carrinho = [] # lista onde ficarao os produtos cadastrados

def ler_produto():
    produto.nome = input("Produto: ");
    produto.quantidade = int(input("Quantidade: "));
    produto.preco = float(input("Preço unitário: "));
    carrinho.append(produto)

def calcular_subtotal(carrinho):
    soma = 0
    for i in carrinho:
        soma += i.quantidade * i.preco
    return soma

def calcular_desconto(subtotal):
    if subtotal > 500:
        return subtotal * 0.1
    elif subtotal > 200:
        return subtotal * 0.05
    else:
        return 0

def calcular_total(subtotal, desconto):
    return subtotal - desconto

def imprimir_cupom(carrinho, subtotal, desconto, total):
    print(f'{"PRODUTO":20}{"QTD":4}{"PREÇO":>20}\n')
    for i in carrinho:
        print(f'{i.nome:20}{i.quantidade:<4}{i.preco:>20.2f}')
    print(f'\nSUBTOTAL:{subtotal:.>35.2f}\nDESCONTO:{desconto:.>35}\nTOTAL:{total:.>38.2f}')


while True:
    produto = Produto();
    ler_produto()
    sair = input("Produto adicionado com sucesso! Pressione Enter para adicionar mais um ou qualquer tecla para sair.\n");
    if sair == "":
        continue
    else:
        break

subtotal = calcular_subtotal(carrinho)
desconto = calcular_desconto(subtotal)
total = calcular_total(subtotal, desconto)
imprimir_cupom(carrinho, subtotal, desconto, total)
