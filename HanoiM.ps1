# Verifique se está executando no PowerShell 7 ou superior
if ($PSVersionTable.PSVersion.Major -lt 7) {
    Write-Error "Este script requer o PowerShell 7 ou superior."
    exit
}

# Caminho para o módulo
$modulePath = ".\HanoiModule.psm1"  # Atualize este caminho conforme necessário

# Definição das instâncias de discos que serão processadas
#$diskCounts = 1, 10, 20, 30, 40, 41
$diskCounts = 1
$maxThreads = 10

# Executar as instâncias em paralelo utilizando ForEach-Object -Parallel
$results = $diskCounts | ForEach-Object -Parallel {
    param ($disk, $modulePath)

    # Importar o módulo
    Import-Module $modulePath

    # Executar e retornar o resultado
    Execute-Hanoi -totalDiscs $disk

} -ThrottleLimit $maxThreads -ArgumentList $modulePath

# Exibir os resultados
foreach ($result in $results) {
    Write-Host "`nDiscos: $($result.DiskCount)" -ForegroundColor Green
    Write-Host "Número de movimentos: $($result.MoveCount)" -ForegroundColor Green
    Write-Host "Tempo gasto: $($result.ElapsedTime)" -ForegroundColor Yellow
}