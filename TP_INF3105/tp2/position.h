/* Squelette de départ TP2
 * TP2 - Géocodage inversé
 * UQAM / Département d'informatique
 * INF3105 - Structures de données et algorithmes
 * http://ericbeaudry.uqam.ca/INF3105/tp2/
 */

#if !defined(_POSITION__H_)
#define _POSITION__H_
#include <iostream>

class Position {
  public:
    double distance(const Position&) const;

  private:
    double latitude;
    double longitude;

  friend std::ostream& operator << (std::ostream&, const Position&);
  friend std::istream& operator >> (std::istream&, Position&);
};

#endif

