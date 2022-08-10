// import { Item } from 'core/item'
import { ItemGateway } from './gateway'

const getAllItems = (fetchMethod: typeof fetch): Promise<Response> => {
  const url = 'http://localhost:5000/inventory'
  const response = fetchMethod(url, {
    method: 'GET',
    mode: 'no-cors',
  })
  return response
}

export class ApiClient implements ItemGateway {
  public constructor(private fetchMethod: typeof fetch) {}
  getAllItems = () => getAllItems(this.fetchMethod)
}
