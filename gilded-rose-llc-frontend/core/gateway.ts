import { Item } from 'core/item'
import { AdminItem } from './admin-item'

export interface ItemGateway {
  getAllItems(): Promise<Item[]>
  updateAllItems(): Promise<AdminItem[]>
}
