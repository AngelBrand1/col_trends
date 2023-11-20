<script setup lang="ts">
import router from '@/router';
import { useQueryStore } from '@/stores/queryParameters';

    const {query} = useQueryStore();

    const login = () => {
      if (!query.userName) {
        alert('Debe ingresar un nombre para poder continuar.');
        return;
      }

      alert('¡Ha iniciado sesión con éxito!');
      router.push('/home/create')
    };
</script>

<template>
  <div>
    <input type="text" v-model="query.userName" placeholder="Ingrese su nombre" />
    <button @click="login">Iniciar sesión</button>
  </div>
</template>