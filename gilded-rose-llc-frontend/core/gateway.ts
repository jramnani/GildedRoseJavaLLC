import { Item } from 'core/item'

export interface ItemGateway {
  getAllItems(): Promise<Response>
}
