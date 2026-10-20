/* Squelette de départ TP2
 * TP2 - Géocodage inversé
 * UQAM / Département d'informatique
 * INF3105 - Structures de données et algorithmes
 * http://ericbeaudry.uqam.ca/INF3105/tp2/
 */

#include <math.h>
#include <assert.h>
#include "position.h"
#define RAYONTERRE 6371004  // en mètres
#define PI 3.14159265359


double Position::distance(const Position& pos) const {
  double s1 = sin((pos.latitude-latitude)/2);
  double s2 = sin((pos.longitude-longitude)/2);
  return 2*RAYONTERRE * asin(sqrt(s1*s1 + cos(latitude)*cos(pos.latitude)*s2*s2));
}

std::istream& operator >> (std::istream& is, Position& pos) {
  char po, virgule, pf;
  is >> po;
  if(is){
    is >> pos.latitude >> virgule >> pos.longitude >> pf;
    assert(po=='(');
    assert(virgule==',');
    assert(pf==')');
    pos.longitude *= PI / 180.0;
    pos.latitude *=  PI / 180.0;
  }
  return is;
}

std::ostream& operator << (std::ostream& os, const Position& pos) {
  os << "(" 
     << (pos.latitude * 180.0 / PI)
     << "," 
     << (pos.longitude * 180.0 / PI)
     << ")";
  return os;
}

