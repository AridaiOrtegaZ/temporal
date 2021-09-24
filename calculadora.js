function setResult(value) {
    document.getElementById('resultado').innerHTML = value;
}
function getResult() {
    return(document.getElementById('resultado').innerHTML);
}
function add(key) { 
    var resultado = getResult();
    if (resultado!='0' || isNaN(key)) setResult(resultado + key);
    else setResult(key);
}
function calc() {
    var resultado = eval(getResult()); 
    setResult(resultado);
}
function el() { 
    setResult(0);
}