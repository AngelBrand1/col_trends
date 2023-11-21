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

<style lang="scss">
.ctn-login {
  height: 100vh;
  width: 100vw;
  background-color: #ffffff;
  display: grid;
  justify-content: center;
  align-items: center;
  div {
    height: fit-content;
    justify-content: center;
    display: grid;
    gap: 10px;
  }
}
</style>

<template scoped>
      <div class="ctn-login">
        <div>
          <div>
            <img style="width: 300px" src="@/assets/app-icon.png" alt="Logo" class="logo" />
          </div>
          <div>
            <h2>Colombia Trends</h2>
          </div>
        <div>
          <input type="text" v-model="query.userName" placeholder="Ingrese su nombre" />
        </div>
        <div>
          <input type="button" @click="login" value="Iniciar sesión"/>
        </div>

        </div>
    </div>
</template>