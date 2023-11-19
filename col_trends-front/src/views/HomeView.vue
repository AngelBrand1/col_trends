<script setup lang="ts">
import { URL_BACK } from '@/env';
import GraphicVisulize from './../components/GraphicVisulize.vue';
import { useQueryStore } from '@/stores/queryParameters';
const { query } = useQueryStore();

const executeQuery = async () => {

  let res:any = await fetch(`${URL_BACK}/createquery`, { 
    method: "POST", 
    body: JSON.stringify(query),
    headers: {
      "Content-Type": "application/json",
    } })
    .catch(() => null);
  res = await res.json();
  console.log(res);
}
</script>

<template>
  <div class="home-view">
    <div class="c1 height-width-100">
      <div class="btn">
        <RouterLink to="/create">
          <input type="button" value="Create" class="height-width-100">
        </RouterLink>
        <RouterLink to="/saved">
          <input type="button" value="Saved" class="height-width-100">
        </RouterLink>
      </div>
      <div class="cont-data">
        <RouterView />
      </div>
      <div class="btn-execute">
        <input @click="executeQuery" type="button" value="Execute" style="width: 44%;height: 100%;">
      </div>
    </div>
    <div class="c2 height-width-100">
      <div class=""></div>
      <GraphicVisulize />
    </div>
    <div class="c3 height-width-100">
    </div>
  </div>
</template>

<style lang="scss">
.home-view {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-rows: 3fr 1fr;
  width: 100%;
  height: 100%;
  padding: 0%;
  margin: 0%;

  .c1 {
    border-right-style: solid;
    border-width: 1px;
    border-color: rgb(185, 185, 185);
    grid-row: 1/-1;
    display: grid;
    grid-template-rows: 1fr 15fr 1fr;

    .btn {
      padding: 1px;
      display: grid;
      grid-template-columns: 1fr 1fr;
      grid-row: 1/2;
    }

    .cont-data {
      padding: 8px;
    }

    .btn-execute {
      display: flex;
      align-items: center;
      justify-content: center;
      padding-bottom: 7px;
    }
  }

  .c2 {
    border-bottom-style: solid;
    border-width: 1px;
    border-color: rgb(185, 185, 185);

  }

  .c3 {}
}</style>