<script setup lang="ts">
import { URL_BACK } from '@/env';
import HeaderApp from './../components/HeaderApp.vue';
import TableContent from './../components/TableContent.vue';
import { useQueryStore } from '@/stores/queryParameters';
import { useData } from '@/stores/data';
import { storeToRefs } from 'pinia';
import { ref } from 'vue';
const loading = ref<Boolean>(false);
const {query} = storeToRefs(useQueryStore());
const { setQueryValue } = useQueryStore();
const {data,setData} = useData();
const executeQuery = async () => {
  let {fields,idUserQuery} = query.value??{};
  if(!fields?.length&&!idUserQuery){
    alert('Debe selecionar algun campo o un query.');
    return;
  }
  loading.value = true;
  let res:any = await fetch(`${URL_BACK}/data/execute`, { 
    method: "POST", 
    body: JSON.stringify(query.value),
    headers: {
      "Content-Type": "application/json",
    } })
    .catch(() => null);
  res = await res.json();
  setData(res);
  loading.value = false;
}
const saveQuery = async () => {
  loading.value = true;
  let res:any = await fetch(`${URL_BACK}/userquery/savequery`, { 
    method: "POST", 
    body: JSON.stringify(query.value),
    headers: {
      "Content-Type": "application/json",
    } })
    .catch(() => null);
    res = await res.json();
    console.log(res);
  loading.value = false;

}
const cleanIdUser = () => {
  setQueryValue({idUserQuery:null,comment:null});
  console.log("id",query);
}
const cleanFields = () => {
setQueryValue({fields:[],order:null,desc:false,filter:null});
  console.log("fields",query);
}
</script>

<template>
    <HeaderApp />
  <div class="home-view content-view">
    <div class="c1 height-width-100">
      <div class="btn">
        <RouterLink to="/home/create">
          <input type="button" value="Create" style="width: 98%;" class="height-width-100" @click="cleanIdUser()">
        </RouterLink>
        <RouterLink to="/home/saved">
          <input type="button" value="Saved" style="width: 98%;" class="height-width-100" @click="cleanFields()">
        </RouterLink>
      </div>
      <div class="cont-data">
        <RouterView />
      </div>
      <div class="btn-execute">
        <input :disabled="loading.valueOf()" @click="executeQuery()" type="button" value="Execute" style="width: 44%;height: 100%;">
      </div>
    </div>
    <div class="c2 height-width-100">
      <TableContent />
    </div>
    <div class="c3 height-width-100">
      <label for="comment">Comment: </label>
      <textarea v-model="query.comment"></textarea>
      <div class="cont-btn-save">
        <input type="button"  :disabled="loading.valueOf()" value="Save" class="btn-save" @click="saveQuery()">
      </div>
    </div>
  </div>
</template>

<style lang="scss">
.content-view{
  height: calc(100% - 91px);
  width: 100%;
}
.home-view {
  display: grid;
  grid-template-columns: 1fr 3fr;
  grid-template-rows: 3fr 1fr;
  padding: 0%;
  margin: 0%;
  height: calc(100% - 91px);
  width: 100%;

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
    padding-left: 5px;
    overflow-y: scroll;
    height: 100%;
  }

  .c3 {
    padding-right: 5px;
    display: grid;
    grid-template-rows: 1fr 10fr 2fr;
    .cont-btn-save{
      display: flex;
      align-items: center;
      justify-content: center;
      .btn-save{
        width: 126px;
        height: 84%;
      }
    }
  }
}</style>