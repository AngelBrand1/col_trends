<script setup lang="ts">
import { ref } from 'vue';
import DataVisualize from './../components/DataVisualize.vue';
import GraphicVisulize from './../components/GraphicVisulize.vue';
const a = ref(1);
a.value = 2;
</script>

<template>
  <div class="home-view">
    <div class="c1 height-width-100">
      <DataVisualize/>
      {{ a }}
    </div>
    <div class="c2 height-width-100">
      <GraphicVisulize/>
    </div>
    <div class="c3 height-width-100">
    </div>
  </div>
</template>

<style lang="scss">
  .home-view{
    display: grid;
    grid-template-columns: 1fr 3fr;
    grid-template-rows: 3fr 1fr;
    width: 100%;
    height: 100%;
    padding: 0%;
    margin: 0%;
    .c1{
      grid-row: 1/-1;
    }
    .c2{

    }
    .c3{

    }
  }
</style>