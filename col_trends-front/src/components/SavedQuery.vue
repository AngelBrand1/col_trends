<script setup lang="ts">
import { URL_BACK } from '@/env';
import { useQueryStore } from '@/stores/queryParameters';
import { onBeforeMount, ref } from 'vue';
const comments:any = ref();
const { query } = useQueryStore();
const getFields = async () => {
    let res: any = await fetch(`${URL_BACK}/userquery/saved`)
        .catch(() => null);
    res = await res?.json();
    comments.value = res;
}
onBeforeMount(() => {
    getFields()
});
const selectComment = (id:number) => {
    query.idUserQuery = id;
}
</script>
<template>
    <div class="comments">

      <div v-for="item in comments" :key="item.id" class="comment" :class="{'comment-active':query.idUserQuery == item.id}" @click="selectComment(item.id)">
        <h4>{{ item.userName }}</h4>
        <p>{{ item.comment }}</p>
       
      </div>
    </div>
  </template>


<style lang="scss" scoped>


.comments{
 
    margin: 10px 0;
    cursor: pointer;
    overflow: auto;
    width: 100%;
    height: 700px;
    p {
    font-size: 16px;
    }
    .comment {
        border-style: solid;
        border-width: 1px 0px 1px 0px;
        border-color: rgb(192, 192, 192);
        margin: 2px;

        &:hover{
        background-color: rgb(203, 225, 252) !important;
        }
    }

    .comment-active{
        background-color: rgb(203, 225, 252) !important;
    }
}

</style>