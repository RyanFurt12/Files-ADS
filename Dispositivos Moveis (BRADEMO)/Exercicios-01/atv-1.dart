// ATIVIDADE 1.
// Crie um programa em Dart para um sistema de cadastro de equipamentos do IFSP. Use `var` para declarar o nome do equipamento como "Impressora 3D", `String`para o local como "Lab de Protótipos", e `dynamic` para o número de patrimônio,inicialmente como `12345`. Em seguida, altere o valor de `patrimonio` para `"12345-A"`(simulando uma mudança de formato). Por fim, imprima os valores e use o operador `is` para mostrar o tipo atual de cada variável. Use comentários no código para explicar por que Dart permite mudar o tipo de patrimonio, mas não de local.

// ignore_for_file: unnecessary_type_check

void main() {
  var nomeEquipamento = "Impressora 3D";
  String local = "Lab de Protótipos";

  dynamic patrimonio = 12345;
  patrimonio = "12345-A";

  print("Nome do Equipamento: $nomeEquipamento \nTipo String: ${nomeEquipamento is String}\n");
  print("Local: $local \nTipo String: ${local is String}\n");
  print("Patrimônio: $patrimonio \nTipo String: ${patrimonio is String}");

  // Explicação:
  // 'dynamic' permite alterar o tipo da variável. Já ao usar 'var' ou um tipo definido, como 'String', se fixa o tipo da variável, então não podemos mudar para outro tipo depois.
}
