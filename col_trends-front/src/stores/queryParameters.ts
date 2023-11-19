import { defineStore } from 'pinia';
import { ref } from 'vue';

interface  QueryParameters {
  idUserQuery?: number;
  fields?: string[];
  filter?: string;
  order?: string;
  desc?: boolean;
}

export const useQueryStore = defineStore(
  'queryStore', () => {
    const query = ref<QueryParameters>({fields:[],desc:false});
    const setQuery = (_query: QueryParameters) => {
      query.value = _query;
    }
    const setQueryValue = (_query: QueryParameters) => {
      query.value = {...query.value ,..._query};
    }
    return {query, setQuery, setQueryValue};
  }
);