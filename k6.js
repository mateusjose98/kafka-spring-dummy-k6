import http from 'k6/http';
import { check, sleep } from 'k6';

// Configurações do teste
export const options = {
    vus: 400, // número de usuários virtuais
    duration: '30s', // duração do teste
};

export default function () {
    const url = 'http://host.docker.internal:8080/pix'; // Ajustado para o IP do host

    const payload = JSON.stringify({
        chaveOrigem: '123',
        chaveDestino: '007',
        valor: '1000.0'
    });

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };

    const res = http.post(url, payload, params);

    // Verifica se o status da resposta é 201
    check(res, { 'status was 201': (r) => r.status === 201 });

    // Pausa de 1 segundo entre as requisições
    sleep(1);
}
