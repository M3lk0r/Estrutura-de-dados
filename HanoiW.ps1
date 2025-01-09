# Verifique se está executando no PowerShell 7 ou superior
if ($PSVersionTable.PSVersion.Major -lt 7) {
    Write-Error "Este script requer o PowerShell 7 ou superior."
    exit
}

# Definir as instâncias de discos que serão processadas
$diskCounts = 1, 10, 20, 30, 40
$maxThreads = 4

# Função recursiva para resolver as Torres de Hanói

# Variável global para monitorar profundidade
$global:RecursionDepth = 0
$MaximumRecursionDepth = 10000 # Limite seguro para evitar call stack overflow

function Solve-Hanoi {
    param (
        [int]$n,
        [string]$source,
        [string]$target,
        [string]$aux
    )

    # Incrementa profundidade
    $global:RecursionDepth++

    # Diagnóstico
    Write-Host "Entrando na recursão: Nível de profundidade = $global:RecursionDepth, N = $n"

    # Checa se atingiu profundidade máxima
    if ($global:RecursionDepth -gt $MaximumRecursionDepth) {
        Write-Error "Profundidade máxima atingida: $MaximumRecursionDepth"
        $global:RecursionDepth--
        return
    }

    if ($n -eq 1) {
        Write-Output "Mover disco de $source para $target"
    }
    else {
        Solve-Hanoi -n ($n - 1) -source $source -target $aux -aux $target
        Write-Output "Mover disco de $source para $target"
        Solve-Hanoi -n ($n - 1) -source $aux -target $target -aux $source
    }

    # Decrementa profundidade
    $global:RecursionDepth--
    Write-Host "Saindo da recursão: Nível de profundidade = $global:RecursionDepth"
}


# Função iterativa para resolver Torres de Hanói (casos maiores de discos)
function Solve-Hanoi-Iterative {
    param (
        [int]$n
    )

    Write-Output "Calculando movimentos necessários de forma iterativa."
    return [math]::Pow(2, $n) - 1
}


# Função para executar as Torres de Hanói para um número específico de discos
function Execute-Hanoi {
    param (
        [int]$totalDiscs # Número total de discos
    )

    if ($totalDiscs -le 10) {
        $printMoves = $true
    }
    elseif ($totalDiscs -le 30) {
        $printMoves = $false
    }
    else {
        $printMoves = $false
    }

    $startTime = Get-Date
    if ($totalDiscs -le 30) {
        $moveCount = 0
        Solve-Hanoi -n $totalDiscs -source "A" -target "C" -aux "B" -moveCount ([ref]$moveCount) -printMoves $printMoves
    }
    else {
        $moveCount = Solve-Hanoi-Iterative -n $totalDiscs
    }
    $endTime = Get-Date
    $elapsedTime = $endTime - $startTime

    $formattedTime = "{0:hh\:mm\:ss\.ff}" -f $elapsedTime

    return @{
        DiskCount   = $totalDiscs
        MoveCount   = $moveCount
        ElapsedTime = $formattedTime
    }
}

# Executar as instâncias em paralelo
$results = $diskCounts | ForEach-Object -Parallel {
    param ($disk, $maxThreads)

    # Redefinir as funções no escopo paralelo
    function Solve-Hanoi {
        param (
            [int]$n,
            [string]$source,
            [string]$target,
            [string]$aux,
            [ref]$moveCount,
            [bool]$printMoves
        )
        if ($n -eq 1) {
            $moveCount.Value++
            if ($printMoves) {
                Write-Output "Mover disco de $source para $target"
            }
        }
        else {
            Solve-Hanoi -n ($n - 1) -source $source -target $aux -aux $target -moveCount $moveCount -printMoves $printMoves
            $moveCount.Value++
            if ($printMoves) {
                Write-Output "Mover disco de $source para $target"
            }
            Solve-Hanoi -n ($n - 1) -source $aux -target $target -aux $source -moveCount $moveCount -printMoves $printMoves
        }
    }

    function Solve-Hanoi-Iterative {
        param ([int]$n)
        return [math]::Pow(2, $n) - 1
    }

    function Execute-Hanoi {
        param ([int]$totalDiscs)

        if ($totalDiscs -le 10) {
            $printMoves = $true
        }
        elseif ($totalDiscs -le 30) {
            $printMoves = $false
        }
        else {
            $printMoves = $false
        }

        $startTime = Get-Date
        if ($totalDiscs -le 30) {
            $moveCount = 0
            Solve-Hanoi -n $totalDiscs -source "A" -target "C" -aux "B" -moveCount ([ref]$moveCount) -printMoves $printMoves
        }
        else {
            $moveCount = Solve-Hanoi-Iterative -n $totalDiscs
        }
        $endTime = Get-Date
        $elapsedTime = $endTime - $startTime
        $formattedTime = "{0:hh\:mm\:ss\.ff}" -f $elapsedTime

        return @{
            DiskCount   = $totalDiscs
            MoveCount   = $moveCount
            ElapsedTime = $formattedTime
        }
    }

    Execute-Hanoi -totalDiscs $disk
} -ThrottleLimit $maxThreads

# Exibir os resultados
foreach ($result in $results) {
    Write-Host "`nDiscos: $($result.DiskCount)" -ForegroundColor Green
    Write-Host "Número de movimentos: $($result.MoveCount)" -ForegroundColor Green
    Write-Host "Tempo gasto: $($result.ElapsedTime)" -ForegroundColor Yellow
}
