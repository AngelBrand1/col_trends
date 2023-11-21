import { json } from 'd3';
import { defineStore } from 'pinia';
import { ref } from 'vue';

interface  QueryParameters {
  comment?: string | null; 
  userName?: string | null ;
  idUserQuery?: number | null;
  fields?: string[];
  filter?: string  | null;
  order?: string | null;
  desc?: boolean;
}

export const useQueryStore = defineStore(
  'queryStore', () => {
    const query = ref<QueryParameters>({fields:[],desc:false});
    const setQuery = (_query: QueryParameters) => {
      query.value = _query;
    }
    const setQueryValue = (_query: QueryParameters) => {
      
      const temp:any = JSON.parse(JSON.stringify({...query.value ,..._query}));
      query.value = temp;
console.log(query.value)
    }
    const resetQueryStore = () => {
      query.value = {fields:[],desc:false};
    }
    return {query, setQuery, setQueryValue,resetQueryStore};
  }
);

